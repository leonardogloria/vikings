package ragnar

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProcessoServiceSpec extends Specification {

    ProcessoService processoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Processo(...).save(flush: true, failOnError: true)
        //new Processo(...).save(flush: true, failOnError: true)
        //Processo processo = new Processo(...).save(flush: true, failOnError: true)
        //new Processo(...).save(flush: true, failOnError: true)
        //new Processo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //processo.id
    }

    void "test get"() {
        setupData()

        expect:
        processoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Processo> processoList = processoService.list(max: 2, offset: 2)

        then:
        processoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        processoService.count() == 5
    }

    void "test delete"() {
        Long processoId = setupData()

        expect:
        processoService.count() == 5

        when:
        processoService.delete(processoId)
        sessionFactory.currentSession.flush()

        then:
        processoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Processo processo = new Processo()
        processoService.save(processo)

        then:
        processo.id != null
    }
}
