package com.br.shopcar.ConfigSecurity;

import com.br.shopcar.Model.User.User;
import com.br.shopcar.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class JwtTokenEnhancer implements TokenEnhancer {

    @Autowired
    private UserRepository repository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,
                                     OAuth2Authentication authentication) {
        User user = repository.findByLoginUsername(authentication.getName());

        /*Conteudo a ser adicionado ao token*/
        Map<String, Object> map = new HashMap<>();
        map.put("email",user.getEmail());
        map.put("id", user.getId());
        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
        token.setAdditionalInformation(map);

        return token;
    }
}
