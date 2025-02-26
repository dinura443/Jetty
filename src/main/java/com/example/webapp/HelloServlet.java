package com.example.webapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HelloServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the "name" parameter, default to "Guest" if missing or empty
        String name = req.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            name = "Guest";
        }

        logger.info("Received request from {} with name: {}", req.getRemoteAddr(), name);

        resp.setContentType("text/html");
        resp.getWriter().println(
                "<!DOCTYPE html>" +
                        "<html lang='en'>" +
                        "<head>" +
                        "    <meta charset='UTF-8'>" +
                        "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                        "    <title>Name Display</title>" +
                        "    <script src='https://cdn.tailwindcss.com'></script>" +
                        "    <style>" +
                        "        /* Style the range slider */" +
                        "        input[type='range'] { " +
                        "            -webkit-appearance: none; " +
                        "            width: 200px; " +
                        "            height: 8px; " +
                        "            background: #ddd; " +
                        "            border-radius: 5px; " +
                        "            outline: none; " +
                        "        }" +
                        "        /* Chrome & Safari slider thumb */" +
                        "        input[type='range']::-webkit-slider-thumb { " +
                        "            -webkit-appearance: none; " +
                        "            appearance: none; " +
                        "            width: 20px; " +
                        "            height: 20px; " +
                        "            background: red; " +
                        "            border-radius: 50%; " +
                        "            cursor: pointer; " +
                        "        }" +
                        "        /* Firefox slider thumb */" +
                        "        input[type='range']::-moz-range-thumb { " +
                        "            width: 20px; " +
                        "            height: 20px; " +
                        "            background: red; " +
                        "            border-radius: 50%; " +
                        "            cursor: pointer; " +
                        "        }" +
                        "    </style>" +
                        "</head>" +
                        "<body class='bg-gray-900 text-white flex items-center justify-center min-h-screen'>" +
                        "    <div class='text-center'>" +
                        "        <h1 id='nameText' class='font-bold' style='font-size: 40px;'>" + name + "</h1>" +
                        "        <input type='range' min='10' max='100' value='40' id='slider'>" +
                        "    </div>" +
                        "    <script>" +
                        "        document.getElementById('slider').addEventListener('input', function() {" +
                        "            document.getElementById('nameText').style.fontSize = this.value + 'px';" +
                        "        });" +
                        "    </script>" +
                        "</body>" +
                        "</html>"
        );

        logger.debug("Response sent successfully for user: {}", name);
    }
}
