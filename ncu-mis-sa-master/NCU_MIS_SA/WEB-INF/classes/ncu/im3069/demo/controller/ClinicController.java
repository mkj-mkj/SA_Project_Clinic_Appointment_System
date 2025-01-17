package ncu.im3069.demo.controller;

import java.io.*;
import java.lang.reflect.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;
import ncu.im3069.demo.app.Clinic;
import ncu.im3069.demo.app.ClinicHelper;
import ncu.im3069.tools.JsonReader;

/**
 * The Class ClinicController
 * ClinicController類別（class）主要用於處理Clinic相關之Http請求（Request），繼承HttpServlet
 */

public class ClinicController extends HttpServlet {

        /** The Constant serialVersionUID. */
        private static final long serialVersionUID = 1L;

        /** ch，ClinicHelper之物件與Clinic相關之資料庫方法（Sigleton） */
        private ClinicHelper ch = ClinicHelper.getHelper();

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
                /** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
                JsonReader jsr = new JsonReader(request);
                JSONObject jso = jsr.getObject();

                /** 取出經解析到JSONObject之Request參數 */
                String clinic_name = jso.getString("clinic_name");
                Integer dept_id = jso.getInt("dept_id");

                /** 建立一個新的Clinic物件 */
                Clinic c = new Clinic(clinic_name, dept_id);

                /** 後端檢查是否有欄位為空值，若有則回傳錯誤訊息 */
                if (clinic_name.isEmpty() || dept_id == null) {
                        /** 以字串組出JSON格式之資料 */
                        String resp = "{\"status\": \'400\', \"message\": \'欄位不能有空值\', \'response\': \'\'}";
                        /** 透過JsonReader物件回傳到前端（以字串方式） */
                        jsr.response(resp, response);
                }
                /** 透過ClinicHelper物件的checkDuplicate()檢查該門診之名稱是否有重複 */
                else if (!ch.checkDuplicate(c)) {
                        /** 透過ClinicHelper物件的create()方法新建一個門診至資料庫 */
                        JSONObject data = ch.create(c);

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "成功! 新增門診資料...");
                        resp.put("response", data);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                } else {
                        /** 以字串組出JSON格式之資料 */
                        String resp = "{\"status\": \'400\', \"message\": \'新增門診失敗，此門診名稱重複！\', \'response\': \'\'}";
                        /** 透過JsonReader物件回傳到前端（以字串方式） */
                        jsr.response(resp, response);
                }
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
                /** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
                JsonReader jsr = new JsonReader(request);
                /** 若直接透過前端AJAX之data以key=value之字串方式進行傳遞參數，可以直接由此方法取回資料 */
                String id = jsr.getParameter("id");

                /** 判斷該字串是否存在，若存在代表要取回個別門診之資料，否則代表要取回全部資料庫內門診之資料 */
                if (id.isEmpty()) {
                        /** 透過ClinicHelper物件之getAll()方法取回所有門診之資料，回傳之資料為JSONObject物件 */
                        JSONObject query = ch.getAll();

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "所有門診資料取得成功");
                        resp.put("response", query);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                } else {
                        /** 透過ClinicHelper物件的getByID()方法自資料庫取回該門診之資料，回傳之資料為JSONObject物件 */
                        JSONObject query = ch.getByID(id);

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "門診資料取得成功");
                        resp.put("response", query);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                }
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
                /** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
                JsonReader jsr = new JsonReader(request);
                JSONObject jso = jsr.getObject();

                /** 取出經解析到JSONObject之Request參數 */
                int id = jso.getInt("id");

                /** 透過ClinicHelper物件的deleteByID()方法至資料庫刪除該門診，回傳之資料為JSONObject物件 */
                JSONObject query = ch.deleteByID(id);

                /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                JSONObject resp = new JSONObject();
                resp.put("status", "200");
                resp.put("message", "門診移除成功！");
                resp.put("response", query);

                /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                jsr.response(resp, response);
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
                /** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
                JsonReader jsr = new JsonReader(request);
                JSONObject jso = jsr.getObject();

                /** 取出經解析到JSONObject之Request參數 */
                int clinic_id = jso.getInt("clinic_id");
                String clinic_name = jso.getString("clinic_name");
                int dept_id = jso.getInt("dept_id");

                /** 透過傳入之參數，新建一個以這些參數之門診Clinic物件 */
                Clinic c = new Clinic(clinic_id, clinic_name, dept_id);

                /** 透過Clinic物件的update()方法至資料庫更新該門診資料，回傳之資料為JSONObject物件 */
                JSONObject data = c.update();

                /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                JSONObject resp = new JSONObject();
                resp.put("status", "200");
                resp.put("message", "成功! 更新門診資料...");
                resp.put("response", data);

                /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                jsr.response(resp, response);
        }
}