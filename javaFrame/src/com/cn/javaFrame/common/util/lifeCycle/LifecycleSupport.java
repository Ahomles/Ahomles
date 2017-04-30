package com.cn.javaFrame.common.util.lifeCycle;

public class LifecycleSupport {
	private Lifecycle lifecycle;
	private LifecycleListener[] listeners;

	public LifecycleSupport(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}

	public void addLifecycleListener(LifecycleListener listener) {
		if (null == listeners) {
			listeners = new LifecycleListener[1];
			listeners[0] = listener;
		} else {
			LifecycleListener[] newListeners = new LifecycleListener[listeners.length + 1];
			for(int i=0;i<listeners.length;i++){
				newListeners[i]=listeners[i];
			}
			newListeners[newListeners.length - 1] = listener;
			listeners = newListeners;
		}
	}

	public LifecycleListener[] getLifeCycleListeners(){
		return listeners;
	}
	
    /** 
     * 触发所有的监听器 
     * @param type  事件类型 
     * @param data   
     */  
    public void fireLifecycleEvent(String type , Object data){  
        if(listeners != null && listeners.length > 0){  
            for (LifecycleListener lifecycleListener : listeners) {  
                lifecycleListener.lifecycleEvent(new LifecycleEvent(lifecycle, type, data));    
            }  
        }  
    }  
}
