package Builder;

class Computer {
    private String cpu;
    private String gpu;
    private int ram;

    public void setCpu(String cpu) { this.cpu = cpu; }
    public void setGpu(String gpu) { this.gpu = gpu; }
    public void setRam(int ram) { this.ram = ram; }

    public String toString() {
        return "Computer [CPU=" + cpu + ", GPU=" + gpu + ", RAM=" + ram + " GB]";
    }
}

class ComputerBuilder {
    private Computer computer = new Computer();

    public ComputerBuilder setCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    public ComputerBuilder setGpu(String gpu) {
        computer.setGpu(gpu);
        return this;
    }

    public ComputerBuilder setRam(int ram) {
        computer.setRam(ram);
        return this;
    }

    public Computer build() {
        return computer;
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        Computer pc = new ComputerBuilder()
                .setCpu("Intel i7")
                .setGpu("RTX 4080")
                .setRam(32)
                .build();

        System.out.println(pc);
    }
}
