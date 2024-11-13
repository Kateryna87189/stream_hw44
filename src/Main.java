import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Дан список строк вида “параметр:значение” (например, “length:8”, “name:Jack” и т.д).
Используя стримы получить map, где параметр – это ключ, его значение – значение.
При этом, если в списке дважды встретился один и тот же параметр,
то значения должны быть указаны через запятую
Например дано: “name:Nick”,“length:8”, “name:Jack”
Вывод: [name - Nick, Jack ; length -> 8]
*/
public class Main {
    public static void main(String[] args) {
        List<String> inputMap = List.of("name:Konstantin", "length:8", "name:Miguel");
        Map<String, String> result = inputMap.stream()
                .collect(Collectors.toMap(
                        s -> s.split(":")[0],//розбиваєм рядок та визначаєм ключ
                        s -> s.split(":")[1],//другий рядок як значення
                                (e, newValue) -> e + "," + newValue//об'єднує значення для однакових ключів через кому.
                        ));
       result.forEach((key, value)-> System.out.println(key+"->"+value));
    }
}