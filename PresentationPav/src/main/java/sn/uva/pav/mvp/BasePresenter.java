package sn.uva.pav.mvp;


public abstract class BasePresenter implements BaseViewListener {
	
	protected BaseView view = null;
	
	public void setView(BaseView view){
		this.view = view;
		view.addListener(this);
	}

}