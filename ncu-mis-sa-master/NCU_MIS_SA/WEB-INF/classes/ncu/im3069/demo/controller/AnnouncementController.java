package ncu.im3069.demo.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;
import ncu.im3069.demo.app.Announcement;
import ncu.im3069.demo.app.AnnouncementHelper;
import ncu.im3069.demo.app.Clinic;
import ncu.im3069.tools.JsonReader;

// TODO: Auto-generated Javadoc
/**
 * The Class AnnouncementController<br>
 * AnnouncementController類別（class）主要用於處理Announcement相關之Http請求（Request），繼承HttpServlet
 */

public class AnnouncementController extends HttpServlet {

        /** The Constant serialVersionUID. */
        private static final long serialVersionUID = 1L;

        /** anh，AnnouncementHelper之物件與Announcement相關之資料庫方法（Sigleton） */
        private AnnouncementHelper anh = AnnouncementHelper.getHelper();

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
                String announce_title = jso.getString("announce_title");
                String announce_content = jso.getString("announce_content");
                String update_time = jso.getString("update_time");

                /** 建立一個新的Announcement物件 */
                Announcement an = new Announcement(announce_title, announce_content, update_time);

                /** 後端檢查是否有欄位為空值，若有則回傳錯誤訊息 */
                if (announce_title.isEmpty() || update_time.isEmpty()) {
                        /** 以字串組出JSON格式之資料 */
                        String resp = "{\"status\": \'400\', \"message\": \'欄位不能有空值\', \'response\': \'\'}";
                        /** 透過JsonReader物件回傳到前端（以字串方式） */
                        jsr.response(resp, response);
                }
                /** 透過AnnouncementHelper物件的checkDuplicate()檢查該公告之名稱是否有重複 */
                else if (!anh.checkDuplicate(an)) {
                        /** 透過AnnouncementHelper物件的create()方法新建一個公告至資料庫 */
                        JSONObject data = anh.create(an);

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "成功! 新增公告資料...");
                        resp.put("response", data);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                } else {
                        /** 以字串組出JSON格式之資料 */
                        String resp = "{\"status\": \'400\', \"message\": \'新增公告失敗，此公告重複！\', \'response\': \'\'}";
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
                String seq = jsr.getParameter("seq");

                /** 判斷該字串是否存在，若存在代表要取回個別公告之資料，否則代表要取回全部資料庫內公告之資料 */
                if (seq.isEmpty()) {
                        /** 透過AnnouncementHelper物件之getAll()方法取回所有公告之資料，回傳之資料為JSONObject物件 */
                        JSONObject query = anh.getAll();

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "所有公告資料取得成功");
                        resp.put("response", query);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                } else {
                        /** 透過AnnouncementHelper物件的getBySeq()方法自資料庫取回該公告之資料，回傳之資料為JSONObject物件 */
                        JSONObject query = anh.getBySeq(Integer.parseInt(seq));

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "公告資料取得成功");
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
                int seq = jso.getInt("announce_seq");

                /** 透過AnnouncementHelper物件的deleteBySeq()方法至資料庫刪除該公告，回傳之資料為JSONObject物件 */
                JSONObject query = anh.deleteBySeq(seq);

                /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                JSONObject resp = new JSONObject();
                resp.put("status", "200");
                resp.put("message", "公告移除成功！");
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
                int announce_seq = jso.getInt("announce_seq");
                String announce_title = jso.getString("announce_title");
                String announce_content = jso.getString("announce_content");
                String update_time = jso.getString("update_time");

                /** 透過傳入之參數，新建一個以這些參數之公告Announcement物件 */
                Announcement an = new Announcement(announce_seq, announce_title, announce_content, update_time);

                /** 透過Announcement物件的update()方法至資料庫更新該公告資料，回傳之資料為JSONObject物件 */
                JSONObject data = an.update();

                /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                JSONObject resp = new JSONObject();
                resp.put("status", "200");
                resp.put("message", "成功! 更新公告資料...");
                resp.put("response", data);

                /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                jsr.response(resp, response);
        }
}