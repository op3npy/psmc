package priv.guochun.psmc.website.backstage.webuser.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.webuser.dao.TabWebUserDao;
import priv.guochun.psmc.website.backstage.webuser.model.TabWebUser;
import priv.guochun.psmc.website.backstage.webuser.service.TabWebUserService;

@Service
public class TabWebUserServiceImpl implements TabWebUserService {
	private TabWebUserDao tabWebUserDao;

	public void setTabWebUserDao(TabWebUserDao tabWebUserDao) {
		this.tabWebUserDao = tabWebUserDao;
	}

	@Override
	public MyPage getWebUsersBusinessMethod(MyPage mapage) {
		return tabWebUserDao.getWebUserList(mapage);
	}
	
	@Override
	public int isVaild(String userId, String password) {
		return tabWebUserDao.queryUserCount(userId, password);
	}
	

	@Override
	public Map<String, Object> findUserByCondition(TabWebUser twu) {
		return tabWebUserDao.findUserByCondition(twu);
	}

	@Override
	public void updateUser(TabWebUser twu) {
		tabWebUserDao.updateUser(twu);
	}

	@Override
	public boolean saveOrUpdateBusinessMethod(TabWebUser user) {
		TabWebUser twu = new TabWebUser();
		twu.setUuid(user.getUuid());
		Map<String,Object> map = tabWebUserDao.findUserByCondition(twu);
		if(map == null){
			tabWebUserDao.saveTabWebUser(user);
		}else{
			tabWebUserDao.updateTabWebUserByUuid(user);
		}
		return true;
	}

	@Override
	public boolean executeWebUserUniqueValidate(TabWebUser user) {
		int count = tabWebUserDao.executeWebUserUniqueValidate(user);
		if(count > 0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean deleteWebUsersBusinessMethod(String uuids) {
		tabWebUserDao.deleteWebUsers(uuids);
		return true;
	}
}
