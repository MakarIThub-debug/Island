import com.lakas.creature.animals.Herbivores.*;
import com.lakas.creature.animals.Predators.Wolf;
import com.lakas.field.Field;
import com.lakas.util.Logs;
import com.lakas.util.StandartClass;
import com.lakas.util.UndyingAnimalUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




public class Tests {

    @Test
    public void testGetPossibleDirections() {
        int[][] positions = new int[][]{
                {0, 0}, {0, 1}, {0, 20},
                {1, 0}, {3, 3}, {1, 20},
                {100, 0}, {100, 1}, {100, 20}
        };

        List<String[]> actual = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            String[] act = StandartClass.getPossibleDirections(positions[i][0], positions[i][1]);
            actual.add(act);
        }
        List<String[]> expected = new ArrayList<>();
        expected.add(new String[]{"DOWN","RIGHT"});
        expected.add(new String[]{"DOWN", "LEFT", "RIGHT"});
        expected.add(new String[]{"DOWN", "LEFT"});

        expected.add(new String[]{"UP", "DOWN", "RIGHT"});
        expected.add(new String[]{"UP", "DOWN", "LEFT", "RIGHT"});
        expected.add(new String[]{"UP", "DOWN", "LEFT"});

        expected.add(new String[]{"UP", "RIGHT"});
        expected.add(new String[]{"UP", "LEFT", "RIGHT"});
        expected.add(new String[]{"UP", "LEFT"});

        for (int i = 0; i < expected.size(); i++) {
            for (int j = 0; j < expected.get(i).length; j++) {
                assertEquals(actual.get(i)[j], expected.get(i)[j]);
            }
        }

    }
    @Test
    public void testGetChance() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Field.initializationField();
        UndyingAnimalUtil UndyingAnimalUtil = new UndyingAnimalUtil(3, 3);

        List<Double> actual = new ArrayList<>();
        actual.add(StandartClass.getChance(Wolf.class, Horse.class));
        actual.add(StandartClass.getChance(Wolf.class, Deer.class));
        actual.add(StandartClass.getChance(Wolf.class, Rabbit.class));
        actual.add(StandartClass.getChance(Wolf.class, Mouse.class));
        actual.add(StandartClass.getChance(Wolf.class, Goat.class));
        actual.add(StandartClass.getChance(Wolf.class, Sheep.class));
        actual.add(StandartClass.getChance(Wolf.class, Boar.class));
        actual.add(StandartClass.getChance(Wolf.class, Buffalo.class));
        actual.add(StandartClass.getChance(Wolf.class, Duck.class));

        List<Double> expected = new ArrayList<>();
        expected.add(0.1);
        expected.add(0.15);
        expected.add(0.6);
        expected.add(0.8);
        expected.add(0.6);
        expected.add(0.7);
        expected.add(0.15);
        expected.add(0.1);
        expected.add(0.4);

        assertEquals(actual, expected);
    }


    @Test
    public void testFieldInit() {
        Field.initializationField();
        int[] actual = new int[2];
        actual[0] = Field.getField().size();
        actual[1] = Field.getField().get(1).size();
        int[] expected = new int[]{100, 20};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testLogs() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Field.initializationField();
        UndyingAnimalUtil utilAnimal = new UndyingAnimalUtil(3, 3);

        Map<String, String> logs = Logs.getLogs();
        List<String> actual = new ArrayList<>();
        List<String> expected = new ArrayList<>();

        actual.add(logs.get("eat.log"));
        actual.add(logs.get("reproduce.log"));
        actual.add(logs.get("move.log"));
        actual.add(logs.get("spawn.log"));
        actual.add(logs.get("deathByHuger.log"));

        expected.add(" съедает ");
        expected.add(" размножается c ");
        expected.add(" перемещается в клетку ");
        expected.add(" появляется в клетке ");
        expected.add(" умирает от голода ");

        assertEquals(actual, expected);
    }
}