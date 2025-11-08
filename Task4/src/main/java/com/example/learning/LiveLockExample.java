package com.example.learning;

public class LiveLockExample {
    static class Spoon {
        private Worker owner;

        public Spoon(Worker owner) {
            this.owner = owner;
        }

        public Worker getOwner() {
            return owner;
        }

        public synchronized void setOwner(Worker owner) {
            this.owner = owner;
        }

        public synchronized void use() {
            System.out.println(owner.getName() + " ест!");
        }
    }

    static class Worker {
        private final String name;
        private boolean hungry = true;

        public Worker(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public boolean isHungry() {
            return hungry;
        }

        public void eatWith(Spoon spoon, Worker partner) {
            while (hungry) {
                if (spoon.getOwner() != this) {
                    try { Thread.sleep(10); } catch (InterruptedException e) {}
                    continue;
                }


                if (partner.isHungry()) {
                    System.out.println(name);
                    spoon.setOwner(partner);
                    continue;
                }


                spoon.use();
                hungry = false;
                System.out.println(name + ": закончил есть!");
                spoon.setOwner(partner);
            }
        }
    }

    public static void main(String[] args) {
        final Worker w1 = new Worker("Поток 1");
        final Worker w2 = new Worker("Поток 2");
        final Spoon spoon = new Spoon(w1);

        Thread t1 = new Thread(() -> w1.eatWith(spoon, w2));
        Thread t2 = new Thread(() -> w2.eatWith(spoon, w1));

        t1.start();
        t2.start();
    }
}