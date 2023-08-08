import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import DateBox from './DateBox'

function StaticExample() {
    return (
        <div
            className="modal"
            style={{ display: 'block', position: 'initial' }}
        >
            <Modal.Dialog   className="modal-dialog">
                <Modal.Header className="modal-header">
                    <Modal.Title>  <div className="modal-background-color">
                            <DateBox></DateBox>
                    </div></Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <p>No bonds mature today</p>
                </Modal.Body>
            </Modal.Dialog>
        </div>
    );
}

export default StaticExample;