package hellorequestparams;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloRequestParamsController {

    @GetMapping("/hello")
    @ResponseBody
    public String tervehdi(@RequestParam String param) {
        return "Hello " + param;
    }
    
    @GetMapping("/params")
    @ResponseBody
    public String returnParams(@RequestParam Map<String, String> parametrit) {
        String str = "{";
        Object[] keys = parametrit.keySet().toArray();
        Object[] values = parametrit.values().toArray();
        
        for(int i = 0; i < parametrit.size(); i++) {
            str += keys[i].toString() + "=" + values[i].toString();
            if(i < parametrit.size() - 1) str += ", ";
        }
        str += "}";
        return str;
    }
}
