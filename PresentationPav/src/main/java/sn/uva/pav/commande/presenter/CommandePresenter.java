package sn.uva.pav.commande.presenter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sn.uva.pav.commande.view.CommandeView;
import sn.uva.pav.mvp.BasePresenter;

@Component
@Scope("prototype")
public class CommandePresenter extends BasePresenter implements CommandeView.CommandeViewListener{

	@Override
	public void buttonClick(String captionBouton) {
		
	}

}
