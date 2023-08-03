import React from 'react'
import SidebarMenu from 'react-bootstrap-sidebar-menu';

const DashBoardSideBar = () => {
    return (
        <>
            <div className='sidebar-menu'>
                <div id='sidebar-link-header'></div>
                <SidebarMenu>
                    <SidebarMenu.Header>
                        <SidebarMenu.Brand > </SidebarMenu.Brand>
                    </SidebarMenu.Header>
                    <SidebarMenu.Body>
                        <SidebarMenu.Nav>
                            <SidebarMenu.Nav.Link href="/securities"> <span id='sidebar-link-text'>Bonds</span></SidebarMenu.Nav.Link>
                            <SidebarMenu.Nav.Link href="/trades"> <span id='sidebar-link-text'>Trades</span> </SidebarMenu.Nav.Link>
                            <SidebarMenu.Nav.Link href="#"> <span id='sidebar-link-text'>User Management</span> </SidebarMenu.Nav.Link>
                        </SidebarMenu.Nav>
                    </SidebarMenu.Body>
                </SidebarMenu>
            </div>

        </>
    )
}

export default DashBoardSideBar