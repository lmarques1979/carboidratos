package carboidratos



import grails.test.mixin.*
import spock.lang.*

@TestFor(AlimentoController)
@Mock(Alimento)
class AlimentoControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.alimentoInstanceList
            model.alimentoInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.alimentoInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def alimento = new Alimento()
            alimento.validate()
            controller.save(alimento)

        then:"The create view is rendered again with the correct model"
            model.alimentoInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            alimento = new Alimento(params)

            controller.save(alimento)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/alimento/show/1'
            controller.flash.message != null
            Alimento.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def alimento = new Alimento(params)
            controller.show(alimento)

        then:"A model is populated containing the domain instance"
            model.alimentoInstance == alimento
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def alimento = new Alimento(params)
            controller.edit(alimento)

        then:"A model is populated containing the domain instance"
            model.alimentoInstance == alimento
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/alimento/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def alimento = new Alimento()
            alimento.validate()
            controller.update(alimento)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.alimentoInstance == alimento

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            alimento = new Alimento(params).save(flush: true)
            controller.update(alimento)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/alimento/show/$alimento.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/alimento/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def alimento = new Alimento(params).save(flush: true)

        then:"It exists"
            Alimento.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(alimento)

        then:"The instance is deleted"
            Alimento.count() == 0
            response.redirectedUrl == '/alimento/index'
            flash.message != null
    }
}
