package tmp;

import org.jsfr.json.JsonPathListener;
import org.jsfr.json.JsonSurfer;
import org.jsfr.json.JsonSurferJackson;
import org.jsfr.json.ParsingContext;
import org.junit.Test;

import java.io.InputStream;

public class SurfTest {

    @Test
    public void s8() throws Exception {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("s8.json")) {
            JsonSurfer surfer = JsonSurferJackson.INSTANCE;
            surfer.configBuilder().bind("$[0][37]", new JsonPathListener() {
                @Override
                public void onValue(Object value, ParsingContext context) {
                    System.out.println(value);
                }
            }).buildAndSurf(in);
            Runtime rt = Runtime.getRuntime();
            rt.gc();
            System.out.printf("Memory used: %.3f", (double)(rt.totalMemory() - rt.freeMemory())/(1024 * 1024));
        }
    }

    @Test
    public void s16() throws Exception {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("s16.json")) {
            JsonSurfer surfer = JsonSurferJackson.INSTANCE;
            surfer.configBuilder().bind("$[0][37]", new JsonPathListener() {
                @Override
                public void onValue(Object value, ParsingContext context) {
                    System.out.println(value);
                }
            }).buildAndSurf(in);
            Runtime rt = Runtime.getRuntime();
            rt.gc();
            System.out.printf("Memory used: %.3f", (double)(rt.totalMemory() - rt.freeMemory())/(1024 * 1024));
        }
    }
}
