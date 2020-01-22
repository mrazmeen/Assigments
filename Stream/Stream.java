import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Razmeen
 */
public class Stream {
    
    public static void main(String[] args) {
        Map<String, Integer> map= new HashMap<>();
        map.put("Amal", 90);
        map.put("Kamal", 80);
        map.put("Nimal", 55);
        map.put("Sunil", 40);
        map.put("Bimal", 70);
        System.out.println(map.keySet().stream().sorted().filter(e->map.get(e)>60).collect(Collectors.toList()));
    }
    
}