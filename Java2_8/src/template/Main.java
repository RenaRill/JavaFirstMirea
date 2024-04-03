package template;

public class Main {
    public static void main(String[] args) {
        System.out.println("Рисуем флаг России:");
        AbstractFlag russianFlag = new RussianFlag();
        russianFlag.drawFlag();

        System.out.println("\nРисуем флаг Нидерландов:");
        AbstractFlag netherlandsFlag = new NetherlandsFlag();
        netherlandsFlag.drawFlag();
    }
}