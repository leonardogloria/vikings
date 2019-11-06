package ragnar

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProcessoController {

    ProcessoService processoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond processoService.list(params), model:[processoCount: processoService.count()]
    }

    def show(Long id) {
        respond processoService.get(id)
    }

    def create() {
        respond new Processo(params)
    }

    def save(Processo processo) {
        if (processo == null) {
            notFound()
            return
        }

        try {
            processoService.save(processo)
        } catch (ValidationException e) {
            respond processo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'processo.label', default: 'Processo'), processo.id])
                redirect processo
            }
            '*' { respond processo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond processoService.get(id)
    }

    def update(Processo processo) {
        if (processo == null) {
            notFound()
            return
        }

        try {
            processoService.save(processo)
        } catch (ValidationException e) {
            respond processo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'processo.label', default: 'Processo'), processo.id])
                redirect processo
            }
            '*'{ respond processo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        processoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'processo.label', default: 'Processo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'processo.label', default: 'Processo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
