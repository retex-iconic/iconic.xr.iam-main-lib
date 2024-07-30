package com.retexspa.xr.ms.iam.main.query.helpers;

public class NativeQueryHelper extends com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper {

  public String ruoliIncassiNativeQuery() {
    return "SELECT " +
        "    t.id_societa, " +
        "    t.id_app, " +
        "    t.nome_ruolo AS cod_ruolo, " +
        "    t.des_ruolo, " +
        "    CASE " +
        "        WHEN t.flg_cassa = 'S' THEN 'CASSE' " +
        "        WHEN t.flg_ufficio = 'S' THEN 'UFFICIO' " +
        "        ELSE NULL " +
        "    END AS tarz_cod_zona_ruolo, " +
        "    COALESCE(t.livello, 0) AS livello, " +
        "    t.flg_cassa, " +
        "    t.flg_ufficio, " +
        "    COALESCE(t.flg_validazione, 'N') AS flg_validazione " +
        "FROM " +
        "    ( " +
        "        SELECT " +
        "            s.codice AS id_societa, " +
        "            a.codice AS id_app, " +
        "            ra.nome AS nome_ruolo, " +
        "            ra.descrizione AS des_ruolo, " +
        "            MAX(CASE WHEN atr.nome_attributo = 'FLG_CASSA' THEN valore END) AS flg_cassa, " +
        "            MAX(CASE WHEN atr.nome_attributo = 'FLG_UFFICIO' THEN valore END) AS flg_ufficio, " +
        "            MAX(CASE WHEN atr.nome_attributo = 'FLG_VALIDAZIONE' THEN valore END) AS flg_validazione, " +
        "            MAX(ra.livello_iam) AS livello " +
        "        FROM " +
        "            anag_attributi_ruoli atr " +
        "            JOIN attributi_ruoli ar ON ar.attributo_ruolo_id = atr.id " +
        "            JOIN ruoli_applicazione ra ON ra.id = ar.ruolo_id " +
        "            JOIN applicazioni a ON a.id = atr.applicazioni_id " +
        "            JOIN societa s ON s.id = a.societa_id " +
        "        GROUP BY " +
        "            s.codice, a.codice, ra.nome, ra.descrizione " +
        "    ) AS t " +
        "WHERE " +
        "    t.flg_cassa = 'S' " +
        "    OR t.flg_ufficio = 'S';";
  }

  public String menuNativeQuery() {
    return "WITH RECURSIVE TREE AS (" +
        "  SELECT " +
        "    r.routing_id, " +
        "    TM.titolo RADICE, " +
        "    TM.ID_MENU ID_RADICE, " +
        "    TM.ID_MENU ROOT_ID, " +
        "    TM.ordinamento ROOT_SORT, " +
        "    TM.ID_MENU, " +
        "    TM.PID_MENU, " +
        "    TM.ordinamento, " +
        "    TM.titolo, " +
        "    TM.menu_char_id, " +
        "    ro.url_link, " +
        "    TM.icone, " +
        "    TM.QUERY_PARAMS, " +
        "    TM.home_pagina, " +
        "    TM.menu_name, " +
        "    TM.menu_default " +
        "  FROM " +
        "    public.menu TM " +
        "    INNER JOIN public.ruoli_routing r ON r.routing_id = tm.routing_id " +
        "    INNER JOIN public.routing ro ON r.routing_id = ro.id " +
        "    INNER JOIN public.ruoli_applicazione ra ON ra.id = r.ruolo_id " +
        "  WHERE " +
        "    PID_MENU = '0' " +
        "    AND COALESCE(r.flg_attiva, 'S') <> 'N' " +
        "    AND ra.id = :roleId " +
        "    AND TM.menu_name = :menuName " +
        "  UNION SELECT " +
        "    r.routing_id, " +
        "    TREE.RADICE, " +
        "    TREE.ID_RADICE, " +
        "    TREE.ROOT_ID, " +
        "    TREE.ROOT_SORT, " +
        "    TMTREE.ID_MENU, " +
        "    TMTREE.PID_MENU, " +
        "    TMTREE.ordinamento, " +
        "    TMTREE.titolo, " +
        "    TMTREE.menu_char_id, " +
        "    ro.URL_LINK, " +
        "    TMTREE.icone, " +
        "    TMTREE.QUERY_PARAMS, " +
        "    TMTREE.home_pagina, " +
        "    TMTREE.menu_name, " +
        "    TMTREE.menu_default " +
        "  FROM " +
        "    public.menu TMTREE " +
        "    INNER JOIN public.ruoli_routing r ON r.routing_id = TMTREE.routing_id " +
        "    INNER JOIN public.routing ro ON r.routing_id = ro.id " +
        "    INNER JOIN public.ruoli_applicazione ra ON ra.id = r.ruolo_id " +
        "    JOIN TREE ON TREE.ID_MENU = TMTREE.PID_MENU " +
        "  WHERE " +
        "    COALESCE(r.flg_attiva, 'S') <> 'N' " +
        "    AND ra.id = :roleId " +
        "    AND TMTREE.menu_name = :menuName " +
        ") " +
        "SELECT distinct" +
        "  CHR(123) || '\"title\":\"' || TREE.titolo || '\"' || CASE " +
        "    WHEN (ro.url_link IS NOT NULL) THEN " +
        "      ', \"link\":\"' || ro.url_link || '\"' " +
        "    ELSE " +
        "      '' " +
        "  END || CASE " +
        "    WHEN (TREE.icone IS NOT NULL) THEN " +
        "      ', \"icon\": \"' || TREE.icone || '\" ' " +
        "    ELSE " +
        "      '' " +
        "  END || CASE " +
        "    WHEN (TREE.menu_name IS NOT NULL) THEN " +
        "      ', \"menu_name\": \"' || TREE.menu_name || '\" ' " +
        "    ELSE " +
        "      '' " +
        "  END || CASE " +
        "    WHEN (TREE.menu_default IS NOT NULL) THEN " +
        "      ', \"menu_default\": \"' || TREE.menu_default || '\" ' " +
        "    ELSE " +
        "      '' " +
        "  END || CASE " +
        "    WHEN (query_params IS NOT NULL) THEN " +
        "      ', \"queryParams\": ' || query_params || ' ' " +
        "    ELSE " +
        "      '' " +
        "  END || CASE " +
        "    WHEN home_pagina = 'S' THEN " +
        "      ', \"home\":true ' " +
        "    ELSE " +
        "      '' " +
        "  END strjson, " +
        "  NOT EXISTS ( " +
        "    SELECT * " +
        "    FROM public.menu M " +
        "    WHERE M.PID_MENU = TREE.ID_MENU " +
        "  ) AS ISLEAF, " +
        "  RADICE, " +
        "  ID_RADICE, " +
        "  ID_MENU, " +
        "  PID_MENU, " +
        "  ROOT_SORT, " +
        "  ordinamento, " +
        "  tree.titolo, " +
        "  menu_char_id, " +
        "  ro.URL_LINK, " +
        "  tree.icone, " +
        "  QUERY_PARAMS, " +
        "  home_pagina, " +
        "  CASE WHEN (PID_MENU = 0) THEN 0 ELSE 1 end pid_order, " +
        "  menu_name, " +
        "  menu_default " +
        "FROM " +
        "  TREE " +
        "  INNER JOIN public.ruoli_routing r ON r.routing_id = TREE.routing_id " +
        "  INNER JOIN public.routing ro ON r.routing_id = ro.id AND ro.url_link = TREE.url_link " +
        "ORDER BY " +
        "  ROOT_SORT, " +
        "  pid_order, " +
        "  ORDINAMENTO";

  }

}
