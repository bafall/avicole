package sn.uva.pav.panier.presenter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import sn.uva.pav.mvp.BasePresenter;
import sn.uva.pav.panier.view.PanierView;

@Component
@Scope("prototype")
public class PanierPresenter extends BasePresenter implements PanierView.PanierViewListener{

	@Override
	public void buttonClick(String captionBouton) {
		// TODO Auto-generated method stub
		
	}

}
