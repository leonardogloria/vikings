package ragnar

import grails.converters.JSON

class LoginController {

    def index() {
        session.setAttribute("user","leogloria")
    }
    def doLogin(Usuario usuario){
        println usuario as JSON
        session.setAttribute("user",usuario)
        render "logado"
    }
    def comprar(){
        if(!session['user']){
            render "nao logado"
        }else {
            render "logado"
        }
    }
}
