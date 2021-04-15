package basic.designPatterns.adapterPattern;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");

        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("avi", "mind me.avi");
    }
}
