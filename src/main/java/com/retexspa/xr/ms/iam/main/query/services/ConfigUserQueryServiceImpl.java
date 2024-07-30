package com.retexspa.xr.ms.iam.main.query.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.retexspa.xr.ms.iam.main.core.dto.configUser.MenuDTO;
import com.retexspa.xr.ms.iam.main.core.dto.configUser.NotificheDTO;
import com.retexspa.xr.ms.iam.main.core.dto.configUser.RoutingDTO;
import com.retexspa.xr.ms.iam.main.core.dto.configUser.RoutingSectionsDTO;
import com.retexspa.xr.ms.iam.main.core.searchRequest.ConfigUserSearchRequest;
import com.retexspa.xr.ms.iam.main.query.entities.MenuQueryEntity;
import com.retexspa.xr.ms.iam.main.query.entities.NotificheQueryEntity;
import com.retexspa.xr.ms.iam.main.query.entities.RoutingQueryEntity;
import com.retexspa.xr.ms.iam.main.query.entities.RoutingSectionsQueryEntity;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliApplicazioneQueryEntity;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliNotificheQueryEntity;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliRoutingQueryEntity;
import com.retexspa.xr.ms.iam.main.query.entities.RuoliRoutingSectionsQueryEntity;
import com.retexspa.xr.ms.iam.main.query.helpers.NativeQueryHelper;

@Service
public class ConfigUserQueryServiceImpl implements ConfigUserQueryService {

        @PersistenceContext
        private EntityManager entityManager;

        public String getConfigUser(ConfigUserSearchRequest query) throws JsonProcessingException {
                String jsonRouting = getRouting(query.getRoleId());
                String jsonMenu = getMenu(query.getRoleId());
                String jsonNotifiche = getNotifiche(query.getRoleId());

                String str = "{\"routing\":" +
                                jsonRouting +
                                "," +
                                "\"menu\":" +
                                jsonMenu +
                                "," +
                                "\"notifiche\":" +
                                jsonNotifiche +
                                "}";

                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                ObjectMapper mapper = new ObjectMapper();
                Object json = mapper.readValue(str, Object.class);

                String result = ow.writeValueAsString(json);

                return result;
        }

        public String getRouting(String roleId) throws JsonProcessingException {

                CriteriaBuilder cb = entityManager.getCriteriaBuilder();
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

                // routing
                CriteriaQuery<RoutingDTO> query = cb.createQuery(RoutingDTO.class);
                Root<RuoliRoutingQueryEntity> ruoliRouting = query.from(RuoliRoutingQueryEntity.class);
                Join<RuoliRoutingQueryEntity, RoutingQueryEntity> routingJoin = ruoliRouting.join("routing");
                Join<RuoliRoutingQueryEntity, RuoliApplicazioneQueryEntity> ruoliAppJoin = ruoliRouting.join("ruolo");

                query.multiselect(
                                ruoliRouting.get("routing").get("id").alias("id_routing"),
                                routingJoin.get("titolo").alias("title"),
                                routingJoin.get("subtitolo").alias("subtitle"),
                                routingJoin.get("urlLink").alias("url_link"),
                                routingJoin.get("icone").alias("icon"),
                                routingJoin.get("flgGdpr").alias("flg_access_gdpr"),
                                ruoliRouting.get("flgAttiva").alias("flg_attiva"),
                                ruoliRouting.get("flgDelete").alias("flg_delete"),
                                ruoliRouting.get("flgInsert").alias("flg_insert"),
                                ruoliRouting.get("flgReadonly").alias("flg_read_only"),
                                ruoliRouting.get("flgUpdate").alias("flg_update"));

                query.where(
                                cb.equal(ruoliAppJoin.get("id"), roleId));

                List<RoutingDTO> results = entityManager.createQuery(query).getResultList();

                List<String> idList = results.stream()
                                .map(t -> t.getId_routing())
                                .collect(Collectors.toList());

                // routing sections
                CriteriaQuery<RoutingSectionsDTO> subquery = cb.createQuery(RoutingSectionsDTO.class);
                Root<RuoliRoutingSectionsQueryEntity> ruoliRoutingSectionsQuery = subquery
                                .from(RuoliRoutingSectionsQueryEntity.class);
                Join<RuoliRoutingSectionsQueryEntity, RoutingSectionsQueryEntity> routingSectionsJoint = ruoliRoutingSectionsQuery
                                .join("routingSection");

                // Root<RoutingSectionsQueryEntity> routingSectionsQuery =
                // subquery.from(RoutingSectionsQueryEntity.class);
                // Join<RoutingSectionsQueryEntity, RuoliRoutingSectionsQueryEntity>
                // ruoliRoutingSectionsJoint = routingSectionsQuery
                // .join("id");

                subquery.multiselect(
                                routingSectionsJoint.get("routing").get("id"),
                                routingSectionsJoint.get("codice"),
                                routingSectionsJoint.get("descrizione"),
                                ruoliRoutingSectionsQuery.get("flgAttiva"),
                                ruoliRoutingSectionsQuery.get("flgDelete"),
                                ruoliRoutingSectionsQuery.get("flgInsert"),
                                ruoliRoutingSectionsQuery.get("flgReadonly"),
                                ruoliRoutingSectionsQuery.get("flgUpdate"))
                                .where(routingSectionsJoint.get("routing")
                                                .get("id").in(idList));

                List<RoutingSectionsDTO> sections = entityManager.createQuery(subquery).getResultList();
                results.forEach(r -> {
                        r.setRountingSection(
                                        sections.stream()
                                                        .filter(s -> s.getRoutingId().equals(r.getId_routing()))
                                                        .collect(Collectors.toList()));
                });
                String json = ow.writeValueAsString(results);
                return json;
        }

        public String getMenu(String roleId) {

                CriteriaBuilder cb = entityManager.getCriteriaBuilder();
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

                // routing
                CriteriaQuery<MenuDTO> query = cb.createQuery(MenuDTO.class);
                Root<MenuQueryEntity> menu = query.from(MenuQueryEntity.class);
                Join<MenuQueryEntity, RuoliRoutingQueryEntity> menuRoutingJoin = menu.join("routing");

                query.multiselect(
                                menu.get("menuName").alias("menu_name")).distinct(true);
                // query.where(
                // cb.equal(menuRoutingJoin.get("ruolo").get("id"), roleId));

                List<MenuDTO> results = entityManager.createQuery(query).getResultList();

                String jsonMennu = "";

                NativeQueryHelper NativeQueryHelper = new NativeQueryHelper();
                List<Object[]> resultList = new ArrayList<>();
                Integer pidMenuOld = null;
                Boolean isLeafOld = false;
                Integer idRadiceOld = null;
                Integer numOpenChildren = 0;

                String str = null;
                String select = NativeQueryHelper.menuNativeQuery();

                for (int i = 0; i < results.size(); i++) {
                        pidMenuOld = null;
                        isLeafOld = false;
                        idRadiceOld = null;
                        numOpenChildren = 0;
                        resultList.clear();
                        
                        Query hierarchiaRoots = entityManager
                                        .createNativeQuery(select)
                                        .setParameter("roleId", roleId)
                                        .setParameter("menuName", results.get(i).getMenuName());
                        resultList = hierarchiaRoots.getResultList();

                        str = "";
                        for (Object[] r : resultList) {
                                if (numOpenChildren > 0 && !pidMenuOld.equals(r[5]) && isLeafOld) {
                                        str = str + "] } ";
                                        numOpenChildren = numOpenChildren - 1;
                                }

                                if (numOpenChildren > 0 && !idRadiceOld.equals(r[3]) && isLeafOld) {
                                        while (numOpenChildren > 0) {
                                                str = str + "] } ";
                                                numOpenChildren = numOpenChildren - 1;
                                        }
                                }

                                str = str + (!str.equals("") && isLeafOld ? "," : "") +
                                                r[0] +
                                                (r[1].equals(true) ? "}" : ", \"children\": [");

                                if (r[1].equals(false)) {
                                        numOpenChildren = numOpenChildren + 1;
                                }

                                pidMenuOld = (Integer) r[5];
                                isLeafOld = (Boolean) r[1];
                                idRadiceOld = (Integer) r[3];

                        }

                        while (numOpenChildren > 0) {
                                str = str + "] } ";
                                numOpenChildren = numOpenChildren - 1;
                        }
                  
                        jsonMennu = jsonMennu + ((jsonMennu == "")? "" : "," ) + str;

                };
                jsonMennu = "[" + jsonMennu + "]";
                return jsonMennu;

        }

        public String getNotifiche(String roleId) throws JsonProcessingException {
                CriteriaBuilder cb = entityManager.getCriteriaBuilder();
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

                // routing
                CriteriaQuery<NotificheDTO> query = cb.createQuery(NotificheDTO.class);
                Root<RuoliNotificheQueryEntity> ruoliNotifiche = query.from(RuoliNotificheQueryEntity.class);
                Join<RuoliNotificheQueryEntity, NotificheQueryEntity> notificheJoin = ruoliNotifiche.join("notifica");
                Join<RuoliNotificheQueryEntity, RuoliApplicazioneQueryEntity> ruoliAppJoin = ruoliNotifiche
                                .join("ruolo");
                Join<NotificheQueryEntity, RoutingQueryEntity> routingJoin = notificheJoin.join("routing",
                                JoinType.LEFT); // routingId can be null

                query.multiselect(
                                notificheJoin.get("routing").get("id"),
                                notificheJoin.get("codice"),
                                notificheJoin.get("dettaglio"),
                                notificheJoin.get("flgAttiva"),
                                notificheJoin.get("icone"),
                                notificheJoin.get("titolo"),
                                routingJoin.get("routingCharId"));

                query.where(
                                cb.equal(ruoliAppJoin.get("id"), roleId));

                List<NotificheDTO> notifiche = entityManager.createQuery(query).getResultList();
                String json = ow.writeValueAsString(notifiche);
                return json;
        }

}
