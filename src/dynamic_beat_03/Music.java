package dynamic_beat_03;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../Music/" + name).toURI()); // Music 클래스에 name으로 들어온 음악(Music밑에 저장)의 경로를 뽑는 함수 : toURI()
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}	catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		if(player == null)
			return 0;
		return player.getPosition();
	}
	// 뒤로가기 누르면 해당 곡 안정적으로 종료 하기위함
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt(); 
		// 우리의 게임 프로그램 안에서 노래를 재생시키는 작은 프로그램(쓰레드)을 종료함
	}

	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
