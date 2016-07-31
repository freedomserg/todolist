package com.goit.projects.todolist.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class AddTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskName = request.getParameter("task_name");
        String taskCategory = request.getParameter("task_category");
        HttpSession session = request.getSession();
        Map<String, String> tasks = (LinkedHashMap<String, String>)session.getAttribute("tasks");
        if (tasks == null) {
            tasks = new LinkedHashMap<>();
        }
        tasks.put(taskName, taskCategory);
        session.setAttribute("tasks", tasks);
        response.sendRedirect("todolist.jsp");
    }
}
