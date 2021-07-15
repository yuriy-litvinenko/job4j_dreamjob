package ru.job4j.dream.servlet;

import org.apache.commons.io.FilenameUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class PhotoDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        for (File file : Objects.requireNonNull(new File("c:\\images\\").listFiles())) {
            if (userId.equals(FilenameUtils.removeExtension(file.getName()))) {
                file.delete();
                break;
            }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/candidates.do");
        dispatcher.forward(req, resp);
    }
}
