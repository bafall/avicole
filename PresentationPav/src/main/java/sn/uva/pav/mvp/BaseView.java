package sn.uva.pav.mvp;

import com.vaadin.navigator.View;

public interface BaseView extends View {
	
	public void addListener(BaseViewListener listener);

}