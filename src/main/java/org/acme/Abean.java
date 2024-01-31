package org.acme;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.runtime.Startup;

@Startup
public class Abean {

    private static final Logger LOG = Logger.getLogger(Abean.class);

    String json = """
            {
                "name": "test",
                "subEntities": [
                    {
                        "subName": "test"
                    },
                    {
                        "subName": "test2"
                    }
                ]
            }
                        """;

    Abean(ObjectMapper mapper) {
        Entity entity = null;
        try {
            entity = mapper.readValue(json, Entity.class);
            LOG.infof("%s", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
