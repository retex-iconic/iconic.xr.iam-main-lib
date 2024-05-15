package com.retexspa.xr.ms.iam.main.query.helpers;

public class NativeQueryHelper extends com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper {

  public String menuNativeQuery(){
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
    "    TM.home_pagina " +
    "  FROM " +
    "    public.menu TM " +
    "    INNER JOIN public.ruoli_routing r ON r.routing_id = tm.routing_id " +
    "    INNER JOIN public.routing ro ON r.routing_id = ro.id " +
    "    INNER JOIN public.ruoli_applicazione ra ON ra.id = r.ruolo_id " +
    "  WHERE " +
    "    PID_MENU = '0' " +
    "    AND COALESCE(r.flg_attiva, 'S') <> 'N' " +
    "    AND ra.id = :roleId " +
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
    "    TMTREE.home_pagina " +
    "  FROM " +
    "    public.menu TMTREE " +
    "    INNER JOIN public.ruoli_routing r ON r.routing_id = TMTREE.routing_id " +
    "    INNER JOIN public.routing ro ON r.routing_id = ro.id " +
    "    INNER JOIN public.ruoli_applicazione ra ON ra.id = r.ruolo_id " +
    "    JOIN TREE ON TREE.ID_MENU = TMTREE.PID_MENU " +
    "  WHERE " +
    "    COALESCE(r.flg_attiva, 'S') <> 'N' " +
    "    AND ra.id = :roleId " +
    ") " +
    "SELECT " +
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
    "  home_pagina " +
    "FROM " +
    "  TREE " +
    "  INNER JOIN public.ruoli_routing r ON r.routing_id = TREE.routing_id " +
    "  INNER JOIN public.routing ro ON r.routing_id = ro.id AND ro.url_link = TREE.url_link " +
    "ORDER BY " +
    "  ROOT_SORT, " +
    "  CASE WHEN (PID_MENU = 0) THEN 0 ELSE 1 END, " +
    "  ORDINAMENTO";

  }
  
}
