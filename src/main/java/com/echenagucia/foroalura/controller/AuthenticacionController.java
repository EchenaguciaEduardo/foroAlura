package com.echenagucia.foroalura.controller;

import com.echenagucia.foroalura.domain.users.User;
import com.echenagucia.foroalura.domain.users.dto.DataAuthenticationUser;
import com.echenagucia.foroalura.infraestructure.security.JwtTokenData;
import com.echenagucia.foroalura.infraestructure.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DataAuthenticationUser dataAuthenticationUser) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(dataAuthenticationUser.name(),
                dataAuthenticationUser.pass());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.tokenGenerate((User) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new JwtTokenData(JWTtoken));
    }

}
