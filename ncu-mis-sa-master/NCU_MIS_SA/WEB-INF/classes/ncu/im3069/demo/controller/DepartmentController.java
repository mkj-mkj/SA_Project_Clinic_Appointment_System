package ncu.im3069.demo.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;
import ncu.im3069.demo.app.Department;
import ncu.im3069.demo.app.DepartmentHelper;
import ncu.im3069.tools.JsonReader;

/**
 * The Class DepartmentController<br>
 * DepartmentController類別（class）主要用於處理Department相關之Http請求（Request），繼承HttpServlet
 */

public class DepartmentController extends HttpServlet {

        /** The Constant serialVersionUID. */
        private static final long serialVersionUID = 1L;

        /** deph，MemberHelper之物件與Member相關之資料庫方法（Sigleton） */
        private DepartmentHelper deph = DepartmentHelper.getHelper();

        /**
         * 處理Http Method請求POST方法（新增資料）
         *
         * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
         * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
         * @throws ServletException the servlet exception
         * @throws IOException      Signals that an I/O exception has occurred.
         */
        /**
         * public void doPost(HttpServletRequest request, HttpServletResponse response)
         * throws ServletException, IOException {
         * 
         * }
         */

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
                /** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
                JsonReader jsr = new JsonReader(request);
                /** 若直接透過前端AJAX之data以key=value之字串方式進行傳遞參數，可以直接由此方法取回資料 */
                String id = jsr.getParameter("id");

                /** 判斷該字串是否存在，若存在代表要取回個別科別之資料，否則代表要取回全部資料庫內科別之資料 */
                if (id.isEmpty()) {
                        /** 透過DepartmentHelper物件之getAll()方法取回所有科別之資料，回傳之資料為JSONObject物件 */
                        JSONObject query = deph.getAll();

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "所有科別資料取得成功");
                        resp.put("response", query);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                } else {
                        /** 透過DepartmentHelper物件的getByID()方法自資料庫取回該科別之資料，回傳之資料為JSONObject物件 */
                        JSONObject query = deph.getByID(id);

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "科別資料取得成功");
                        resp.put("response", query);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                }
        }

}