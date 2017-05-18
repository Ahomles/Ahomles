package com.cn.javaFrame.common.util.mvc;

import com.cn.javaFrame.common.util.mvc.observer.BPMObserver;
import com.cn.javaFrame.common.util.mvc.observer.BeatObserver;

public interface Model {
	void initialize();
	void on();
	void off();
	void setBPM(int bpm);
	int  getBPM();
	void registerObserver(BeatObserver o);
	void removeObserver(BeatObserver o);
	void registerObserver(BPMObserver o);
	void removeObserver(BPMObserver o);
}
