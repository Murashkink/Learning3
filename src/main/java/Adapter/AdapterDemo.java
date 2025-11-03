package Adapter;

class OldPrinter {
    public void printText(String text) {
        System.out.println("Печать: " + text);
    }
}


interface Printer {
    void print(String text);
}


class PrinterAdapter implements Printer {
    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    public void print(String text) {
        oldPrinter.printText(text);
    }
}


public class AdapterDemo {
    public static void main(String[] args) {
        Printer printer = new PrinterAdapter(new OldPrinter());
        printer.print("Документ адаптирован успешно!");
    }
}
