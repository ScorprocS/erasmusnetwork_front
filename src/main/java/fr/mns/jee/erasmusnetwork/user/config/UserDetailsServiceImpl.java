package fr.mns.jee.erasmusnetwork.user.config;

import fr.mns.jee.erasmusnetwork.user.model.User;
import fr.mns.jee.erasmusnetwork.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
		return new UserPrincipal(user);
	}
}
