function beforeSubmit(action, actionName){
    $(action).val(actionName);
    return false;
}

function beforeSubmitAndSetValue(action, actionName, id, value){
    $(id).val(value);
    return beforeSubmit(action, actionName);
}