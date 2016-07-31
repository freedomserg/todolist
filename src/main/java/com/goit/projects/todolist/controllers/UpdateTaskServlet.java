package com.goit.projects.todolist.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class UpdateTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<String, String> tasks = (LinkedHashMap<String, String>) session.getAttribute("tasks");
        String[] finishedTasks = request.getParameterValues("complete");
        if (finishedTasks != null) {
            for (String completedTask : finishedTasks) {
                tasks.remove(completedTask);
            }
            session.setAttribute("tasks", tasks);
        }
        response.sendRedirect("todolist.jsp");
    }
}
