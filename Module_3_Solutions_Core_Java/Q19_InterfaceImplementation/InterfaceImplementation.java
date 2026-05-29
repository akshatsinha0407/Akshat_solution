public class InterfaceImplementation {
    interface Playable { void play(); }

    static class Guitar implements Playable {
        public void play() { System.out.println("Playing Guitar..."); }
    }
    static class Piano implements Playable {
        public void play() { System.out.println("Playing Piano..."); }
    }

    public static void main(String[] args) {
        new Guitar().play();
        new Piano().play();
    }
}
