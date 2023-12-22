package ncu.im3069.demo.controller;

import java.io.*;
import java.sql.Timestamp;

import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;
import ncu.im3069.demo.app.Appointment;
import ncu.im3069.demo.app.AppointmentHelper;
import ncu.im3069.demo.app.Clinic;
import ncu.im3069.tools.JsonReader;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class AppointmentController<br>
 * AppointmentController類別（class）主要用於處理Appointment相關之Http請求（Request），繼承HttpServlet
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class AppointmentController extends HttpServlet {

        /** The Constant serialVersionUID. */
        private static final long serialVersionUID = 1L;

        /** aph，AppointmentHelper之物件與Appointment相關之資料庫方法（Sigleton） */
        private AppointmentHelper aph = AppointmentHelper.getHelper();

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
                Integer doctor_id = jso.getInt("doctor_id");
                String user_id = jso.getString("user_id");
                String reserve_time = jso.getString("reserve_time");

                /** 建立一個新的Appointment物件 */ 
                Appointment ap = new Appointment(doctor_id, user_id, reserve_time);

                /** 後端檢查是否有欄位為空值，若有則回傳錯誤訊息 */
                if (user_id.isEmpty() || doctor_id == null || reserve_time == null) {
                        /** 以字串組出JSON格式之資料 */
                        String resp = "{\"status\": \'400\', \"message\": \'欄位不能有空值\', \'response\': \'\'}";
                        /** 透過JsonReader物件回傳到前端（以字串方式） */
                        jsr.response(resp, response);
                }
                /** 透過AppointmentHelper物件的checkDuplicate()檢查該預約是否有重複 */
                else if (!aph.checkDuplicate(ap)) {
                        /** 透過AppointmentHelper物件的create()方法新建一個預約至資料庫 */
                        JSONObject data = aph.create(ap);

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "成功! 新增預約資料...");
                        resp.put("response", data);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                } else {
                        /** 以字串組出JSON格式之資料 */
                        String resp = "{\"status\": \'400\', \"message\": \'新增預約失敗，此預約重複！\', \'response\': \'\'}";
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

                /** 判斷該字串是否存在，若存在代表要取回個別預約之資料，否則代表要取回全部資料庫內預約之資料 */
                if (id.isEmpty()) {
                        /** 透過AppointmentHelper物件之getAll()方法取回所有預約之資料，回傳之資料為JSONObject物件 */
                        JSONObject query = aph.getAll();

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "所有預約資料取得成功");
                        resp.put("response", query);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                } else {
                        /** 透過AppointmentHelper物件的getByID()方法自資料庫取回該預約之資料，回傳之資料為JSONObject物件 */
                        JSONObject query = aph.getByID(id);

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "預約資料取得成功");
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
                String user_id = jso.getString("user_id");
                int doctor_id = jso.getInt("doctor_id");

                /** 透過AppointmentHelper物件的cancel()方法至資料庫刪除該預約，回傳之資料為JSONObject物件 */
                JSONObject query = aph.cancel(user_id, doctor_id);

                /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                JSONObject resp = new JSONObject();
                resp.put("status", "200");
                resp.put("message", "取消預約成功！");
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
                String user_id = jso.getString("user_id");
                int doctor_id = jso.getInt("doctor_id");
                String reserve_time = jso.getString("reserve_time");
                int appointment_num = jso.getInt("appointment_num");

                /** 透過傳入之參數，新建一個以這些參數之預約Appointment物件 */
                Appointment ap = new Appointment(doctor_id, user_id, reserve_time, appointment_num);

                /** 透過Appointment物件的update()方法至資料庫更新該預約資料，回傳之資料為JSONObject物件 */
                JSONObject data = ap.update();

                /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                JSONObject resp = new JSONObject();
                resp.put("status", "200");
                resp.put("message", "成功! 更新預約資料...");
                resp.put("response", data);

                /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                jsr.response(resp, response);
        }
}