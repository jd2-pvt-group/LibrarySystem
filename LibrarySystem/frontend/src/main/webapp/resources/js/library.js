function beforeSubmit(action, actionName){
    $(action).val(actionName);
    return false;
}

function beforeSubmitAndSetValue(action, actionName, id, value){
    $(id).val(value);
    return beforeSubmit(action, actionName);
}

function submitFormForAction(formId, action){
    $(formId).attr('action',action);
    $(formId).submit();
    return false;
}

function submitForm(formId){
    $(formId).submit();
    return false;
}