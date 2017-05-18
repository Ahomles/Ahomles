package com.cn.javaFrame.common.util.mvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import com.cn.javaFrame.common.util.mvc.Model;
import com.cn.javaFrame.common.util.mvc.observer.BPMObserver;
import com.cn.javaFrame.common.util.mvc.observer.BeatObserver;

public class BeatModel implements Model, MetaEventListener {
	Sequencer sequencer;
	List beatObservers = new ArrayList();
	List bpmObservers = new ArrayList();
	int bpm = 90;
	Sequence sequence;
	Track track;

	@Override
	public void meta(MetaMessage meta) {
		if(meta.getType()==47){
			beatEvent();
			sequencer.start();
			setBPM(getBPM());
		}
	}

	@Override
	public void initialize() {
		setUpMidi();
		buildTrackAndStart();

	}

	@Override
	public void on() {
		sequencer.start();
		setBPM(90);
	}

	@Override
	public void off() {
		setBPM(0);
		sequencer.stop();
	}

	@Override
	public void setBPM(int bpm) {
		this.bpm=bpm;
		sequencer.setTempoInBPM(getBPM());
	}

	@Override
	public int getBPM() {
		return bpm;
	}

	
	void beatEvent(){
		notifyBeatObservers();
	}
	
	public void notifyBeatObservers() {
		for(int i=0;i<beatObservers.size();i++){
			BeatObserver beatObserver=(BeatObserver)beatObservers.get(i);
			beatObserver.updateBeat();
		}
	}
	public void notifyBPMObservers() {
		for(int i=0;i<bpmObservers.size();i++){
			BPMObserver bpmObserver=(BPMObserver)bpmObservers.get(i);
			bpmObserver.updateBPM();
		}
	}

	@Override
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}
	@Override
	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}

	@Override
	public void removeObserver(BeatObserver o) {
		int i=beatObservers.indexOf(o);
		if(i>=0){
			beatObservers.remove(i);
		}
	}


	@Override
	public void removeObserver(BPMObserver o) {
		int i=bpmObservers.indexOf(o);
		if(i>=0){
			bpmObservers.remove(i);
		}
	}

	// 设置Midi的基本参数
	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addMetaEventListener(this);
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(getBPM());
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

	public void buildTrackAndStart() {
		int[] trackList = { 35, 0, 46, 0 };
		sequence.deleteTrack(null);
		track = sequence.createTrack();
		
		makeTracks(trackList);
		track.add(makeEvent(144,9,1,0,4));
		
		try {
			sequencer.setSequence(sequence);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}

	}

	public void makeTracks(int[] list) {
		for (int i = 0; i < list.length; i++) {
			int key = list[i];
			if(0!=key){
				track.add(makeEvent(144,9,key,100,i));
				track.add(makeEvent(144,9,key,100,i+1));
			}
		}
	}
	
	public MidiEvent makeEvent(int comd,int chan,int one,int two,int tick){
		MidiEvent event=null;
		try {
			ShortMessage a=new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event=new MidiEvent(a,tick);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		return event;
	}
}
