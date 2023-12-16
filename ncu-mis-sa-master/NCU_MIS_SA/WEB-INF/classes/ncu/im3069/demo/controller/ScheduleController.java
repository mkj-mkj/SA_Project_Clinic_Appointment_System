package ncu.im3069.demo.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;
import ncu.im3069.demo.app.Schedule;
import ncu.im3069.demo.app.ScheduleHelper;
import ncu.im3069.tools.JsonReader;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class ScheduleController<br>
 * ScheduleController類別（class）主要用於處理Schedule相關之Http請求（Request），繼承HttpServlet
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class ScheduleController extends HttpServlet {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** sh，ScheduleHelper之物件與Schedule相關之資料庫方法（Sigleton） */
    private ScheduleHelper sh = ScheduleHelper.getHelper();

    /**
     * 處理Http Method請求POST方法（新增資料）
     *
     * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
     * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * 處理Http Method請求GET方法（取得資料）
     *
     * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
     * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * 處理Http Method請求DELETE方法（刪除）
     *
     * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
     * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * 處理Http Method請求PUT方法（更新）
     *
     * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
     * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    public void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}