<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:p="http://primefaces.org/ui">

<h:head>

</h:head>

<h:body>
    <h:form id="person">
        <p:panelGrid columns="2">
            <f:facet name="header">
                Basic PanelGrid
            </f:facet>
            <h:outputLabel for="firstName" value="First Name" />
            <p:inputText id="firstName" value="#{personWizard.firstName}" />

            <h:outputLabel for="lastName" value="Last name" />
            <p:inputText id="lastName" value="#{personWizard.lastName}" />

            <h:outputLabel for="email" value="email" />
            <p:inputText id="email" value="#{personWizard.lastName}" />


            <p:commandButton action="#{personWizard.save}" update="mydata"
                             value="Save" icon="ui-icon-check" style="margin:0" />

            <h:messages />


        </p:panelGrid>



    </h:form>
</h:body>
</html>
