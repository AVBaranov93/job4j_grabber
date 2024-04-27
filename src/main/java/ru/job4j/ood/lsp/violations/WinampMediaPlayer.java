package ru.job4j.ood.lsp.violations;

public class WinampMediaPlayer extends MediaPlayer {
  /*   Play video is not supported in Winamp player*/
    public void playVideo() {
        throw new RuntimeException("video not supported");
    }
}
