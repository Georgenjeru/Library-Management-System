package com.Admin;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

@WebServlet("/usersReport")
public class AdminPdf extends HttpServlet {

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        /* Create Connection objects */
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "George@23");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /* Define the SQL query */
        ResultSet query_set = null;
        try {
            query_set = stmt.executeQuery("SELECT id,email,name, regNo FROM admins");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /* Step-2: Initialize PDF documents - logical objects */
        Document my_pdf_report = new Document();
        try {
            PdfWriter.getInstance(my_pdf_report, Files.newOutputStream(Paths.get("C:/Users/Admin/Desktop/Systech Documents/Users/users.pdf")));
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        my_pdf_report.open();
        Font bold = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Paragraph paragraph = new Paragraph("Report for Current Members List");
        paragraph.setFont(bold);
        paragraph.setSpacingAfter(8);
        paragraph.setAlignment(5);

        //we have four columns in our table
        PdfPTable my_report_table = new PdfPTable(5);
        //create a cell object
        PdfPCell table_cell;

        while (true) {
            try {
                if (!query_set.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String dept_id = null;
            try {
                dept_id = query_set.getString("id");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            table_cell = new PdfPCell(new Phrase(dept_id));
            my_report_table.addCell(table_cell);
            String dept_name = null;
            try {
                dept_name = query_set.getString("email");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            table_cell = new PdfPCell(new Phrase(dept_name));
            my_report_table.addCell(table_cell);
            String manager_id = null;
            try {
                manager_id = query_set.getString("name");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            table_cell = new PdfPCell(new Phrase(manager_id));
            my_report_table.addCell(table_cell);
            String location_id = null;
            try {
                location_id = query_set.getString("regNo");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        /* Attach report table to PDF */
        try {
            my_pdf_report.add(paragraph);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

        try {
            my_pdf_report.add(my_report_table);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        my_pdf_report.close();

        /* Close all DB related objects */
        try {
            query_set.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Create Connection objects */
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "George@23");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /* Define the SQL query */
        ResultSet query_set = null;
        try {
            query_set = stmt.executeQuery("SELECT id,email,name, regNo FROM admins");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /* Step-2: Initialize PDF documents - logical objects */
        Document my_pdf_report = new Document();
        try {
            PdfWriter.getInstance(my_pdf_report, Files.newOutputStream(Paths.get("C:/Users/Admin/Desktop/Systech Documents/Users/users.pdf")));
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        my_pdf_report.open();
        Font bold = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Paragraph paragraph = new Paragraph("Report for Current members List");
        paragraph.setFont(bold);
        paragraph.setSpacingAfter(8);
        paragraph.setAlignment(5);

        //we have four columns in our table
        PdfPTable my_report_table = new PdfPTable(5);
        //create a cell object
        PdfPCell table_cell;

        while (true) {
            try {
                if (!query_set.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String dept_id = null;
            try {
                dept_id = query_set.getString("id");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            table_cell = new PdfPCell(new Phrase(dept_id));
            my_report_table.addCell(table_cell);
            String dept_name = null;
            try {
                dept_name = query_set.getString("email");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            table_cell = new PdfPCell(new Phrase(dept_name));
            my_report_table.addCell(table_cell);
            String manager_id = null;
            try {
                manager_id = query_set.getString("name");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            table_cell = new PdfPCell(new Phrase(manager_id));
            my_report_table.addCell(table_cell);
            String location_id = null;
            try {
                location_id = query_set.getString("regNo");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        /* Attach report table to PDF */
        try {
            my_pdf_report.add(paragraph);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

        try {
            my_pdf_report.add(my_report_table);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        my_pdf_report.close();

        /* Close all DB related objects */
        try {
            query_set.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("./admin_add.jsp");

    }
}