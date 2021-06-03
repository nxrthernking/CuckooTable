public class RunnerTask2 {
    public static void main(String[] args) {
        CustomList list = new CustomList();
        // Добавление данных в список
        for (int i =0; i < 10; i++){
            list.add(i + 1);
        }

        System.out.println(list); // Вывод исходного списка

        list.swap(); // Меняем местами 1 и последний элемент

        System.out.println(list); // Результат
    }


}
