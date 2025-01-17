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

//     /**
//      * 處理Http Method請求POST方法（新增資料）
//      *
//      * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
//      * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
//      * @throws ServletException the servlet exception
//      * @throws IOException      Signals that an I/O exception has occurred.
//      */
//     public void doPost(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {

//     }

//     /**
//      * 處理Http Method請求GET方法（取得資料）
//      *
//      * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
//      * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
//      * @throws ServletException the servlet exception
//      * @throws IOException      Signals that an I/O exception has occurred.
//      */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
        /** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
        JsonReader jsr = new JsonReader(request);
        /** 若直接透過前端AJAX之data以key=value之字串方式進行傳遞參數，可以直接由此方法取回資料 */
        String clinic_id = jsr.getParameter("clinic_id");

        /** 判斷該字串是否存在，若存在代表要取回個別醫生之資料，否則代表要取回全部資料庫內班表之資料 */
        if (clinic_id.isEmpty()) {
                /** 透過ScheduleHelper物件之getAll()方法取回所有班表之資料，回傳之資料為JSONObject物件 */
                JSONObject query = sh.getAll();

                /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                JSONObject resp = new JSONObject();
                resp.put("status", "200");
                resp.put("message", "所有schedule資料取得成功");
                resp.put("response", query);

                /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                jsr.response(resp, response);
        } else {
                /** 透過DoctorHelper物件的getByID()方法自資料庫取回該醫生之資料，回傳之資料為JSONObject物件 */
                JSONObject query = sh.getBySeq(Integer.parseInt(clinic_id));

                /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                JSONObject resp = new JSONObject();
                resp.put("status", "200");
                resp.put("message", "班表資料取得成功");
                resp.put("response", query);

                /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                jsr.response(resp, response);
        }

     }

//     /**
//      * 處理Http Method請求DELETE方法（刪除）
//      *
//      * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
//      * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
//      * @throws ServletException the servlet exception
//      * @throws IOException      Signals that an I/O exception has occurred.
//      */
//     public void doDelete(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {

//     }

//     /**
//      * 處理Http Method請求PUT方法（更新）
//      *
//      * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
//      * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
//      * @throws ServletException the servlet exception
//      * @throws IOException      Signals that an I/O exception has occurred.
//      */
//     public void doPut(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {

//     }
}
