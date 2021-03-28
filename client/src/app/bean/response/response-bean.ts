import { KeyValue } from '../responseData/key-value';

export class ResponseBean {
    constructor(
        public requestOk                ?: boolean,
        public errorCode                ?: string,
        public messageType              ?: string,        // S -> successMessage ,W -> warningMessage ,E -> errorMessage
        public message                  ?: string,
        public data                     ?: KeyValue[]
    ) {}
}
