#include <GUIConstantsEx.au3>
#include <GuiIPAddress.au3>

Example()

Func Example()
	Local $hGui, $hIPAddress, $hIPAddress2

	$hGui = GUICreate("IP Address Control Set Font Example", 300, 150)
	$hIPAddress = _GUICtrlIpAddress_Create($hGui, 10, 10, 150, 30)
	$hIPAddress2 = _GUICtrlIpAddress_Create($hGui, 10, 50, 150, 30)
	GUISetState(@SW_SHOW)

	_GUICtrlIpAddress_Set($hIPAddress, "24.168.2.128")
	_GUICtrlIpAddress_SetFont($hIPAddress, "Times New Roman", 14, 800, True)
	_GUICtrlIpAddress_Set($hIPAddress2, "24.168.2.128")
	_GUICtrlIpAddress_SetFont($hIPAddress2, "Arial", 10, 300)

	; Wait for user to close GUI
	Do
	Until GUIGetMsg() = $GUI_EVENT_CLOSE
EndFunc   ;==>Example
