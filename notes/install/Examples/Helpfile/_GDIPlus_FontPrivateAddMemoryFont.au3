#include <GDIPlus.au3>
#include <GUIConstantsEx.au3>

Example()

Func Example()
	Local $bFont = _MemFont() ;load binary data (TTF) to use it later in GDI+
	Local $hGUI, $hGraphic, $hBrush, $hFormat, $hFamily, $hFont, $tLayout, $sFontInternalName
	Local $hCollection, $tFont

	$hGUI = GUICreate("GDI+", 720, 235)
	GUISetState()

	_GDIPlus_Startup()
	$hGraphic = _GDIPlus_GraphicsCreateFromHWND($hGUI)
	_GDIPlus_GraphicsSetSmoothingMode($hGraphic, $GDIP_SMOOTHINGMODE_HIGHQUALITY) ;Sets the graphics object rendering quality (anti aliasing)
	_GDIPlus_GraphicsSetTextRenderingHint($hGraphic, $GDIP_TEXTRENDERINGHINT_ANTIALIASGRIDFIT) ;set the anti aliasing for fonts

	$hCollection = _GDIPlus_FontPrivateCreateCollection() ;create a PrivateFontCollection object to add fonts later
	$tFont = DllStructCreate('byte[' & BinaryLen($bFont) & ']') ;create byte struct to add font to collection
	DllStructSetData($tFont, 1, $bFont)
	_GDIPlus_FontPrivateAddMemoryFont($hCollection, $tFont) ;add font to collection

	$hBrush = _GDIPlus_BrushCreateSolid(0xFF00007F) ;create a brush with a defined color for the text
	$hFormat = _GDIPlus_StringFormatCreate() ;create a string format object
	$sFontInternalName = _WinAPI_GetFontMemoryResourceInfo(DllStructGetPtr($tFont)) ;get internal font name
	$hFamily = _GDIPlus_FontFamilyCreate($sFontInternalName, $hCollection) ;create a font family object
	$hFont = _GDIPlus_FontCreate($hFamily, 70) ;create a font object
	$tLayout = _GDIPlus_RectFCreate(0, 0, 720, 235) ;create a $tagGDIPRECTF structure to save x, y position of the text
	_GDIPlus_StringFormatSetAlign($hFormat, 1) ;center text
	_GDIPlus_StringFormatSetLineAlign($hFormat, 1) ;center text
	_GDIPlus_GraphicsDrawStringEx($hGraphic, "AutoIt" & @LF & "forever", $hFont, $tLayout, $hFormat, $hBrush) ;draw the string

	; Loop until user exits
	Do
	Until GUIGetMsg() = $GUI_EVENT_CLOSE

	; Clean up resources
	_GDIPlus_FontDispose($hFont)
	_GDIPlus_FontFamilyDispose($hFamily)
	_GDIPlus_StringFormatDispose($hFormat)
	_GDIPlus_FontPrivateCollectionDispose($hCollection)
	_GDIPlus_BrushDispose($hBrush)
	_GDIPlus_GraphicsDispose($hGraphic)
	_GDIPlus_Shutdown()
EndFunc   ;==>Example

Func _MemFont($bSaveBinary = False, $sSavePath = @ScriptDir) ;compressed base64 saved TTL font
	Local $vMemFont
	$vMemFont &= '+LpAAAEAAAARAEAEAAAQTFRTSHBEFET0AGDEAKi3T1MALzJjo38vAAAEAZgAPGBWRE1YAGXvbW4AAHRoAAAABeBjbWFwEAm6VAMAgAQAAAAD2GN2dCADpEABxwAAFtwAXhgAZnBnbTJHc2AIAAAUAB4BYmdswHlmdq72hAA+AMYARmhoZG14PSgEGzgAS3wAAAuIAGhlYWTfoV8QJQArHAA/NmgAEAs9FAXeAA9UAA8kaG1AdHhqYhtYAA/4AAAAAsxrZXJugLrOrNgAAF4ArwALZGxvY2H2UEALkgAAXVwAI2gAbWF4cALnCnsFAAt4AD8gbmFtZQCNIdAnAABqKAAAAAodcG9zdFD/fgAUgGdIgQ9wgHJlcKaKyrqATwpAgAeago0CAAAhAEgSSF8PPPUACBkD6IAIALxe9gLnggNfJRz/7P6gvQfJA3AABwOBFQMCAIAbA3D+vQAVxAfggA+NB8mCJAkAArOCCLMBcQAgABZIgL2DDwoBNwjAAIIFgAcCA10BkIAEoAACvAKKgA2PgwPAAcUAMgD6ARYAuQcFAIDABwBMQVJBAABAACAhIgLm/4AcACoDcAFDg0mxAAL0AtaBdIAEnYABAEEANQH2ACECAD4AAQI4ACUCAFMAIgNjAAgAAPwAEwG+AAwCABMALwK1AB4CAKAAHwEsACMCAG8AJgFPADkEIAT/9APcwATzAAAvA7AAGQQlAIAoBCIACQOAwAAA5gAbAyH/9wQALgAkA/4ALgGgMgAsAUTACbfAGQB1ADADa//5AwBP//0DYgAxBACs//oEFAAtAyDJAAMD2cALIAAAEAMWAAcDyACKEcAXOkB9PwNowA4AogANAw3//wUgWAAVA8bAH34AAh/ADA0EswAWBABpABwD8AAPAwho//bAEjIEo/8A7wUlAAEEXgCAEwRKAAUDzkC3AKAADwQA//ABoNIAIAI2wBi0wDZoxAGexh+w/x/ZHwAArgBFBYYAPgAIhAAQwVwC8AF+AAKcAbgC0QFIMANuABTCIdAABq10/+3ADwHCJcgAwCU3C8EmwAAewAAhA///NvHFJdAALMIlyQBXABgFB+DARNUdpP/srAI6wErvDjbkDh1gAI4goWH2Dm0OUwAF4SEABqAAHAamABsBYQEC2AFxAw0BAOYDLQGPATsAAihgACMCQwAoAgAuACMB3wAfBwInYgssAnsAKQIgHAAvAObgADEAEivhAAF2YACCADRf4VgiaR8AHwAUABmBABjL/wQBABVfBBYYgwnhFgFgnQC4CRIEAwUBAAAIAgQFBgYDAAYDCQkECQoKAAgJBwoJAwMJAAYICAgLCQkJAAcHCQkDCAgHAAwJCgkLCgkIIAkLDAoKIAUEBQQJBvcDAg0BAwdQBgYICwIAD6AEB3QHAwAACSAMAQAABwk0ChKkAwSsA4IDCg8EDwrCAgUFBBAKgAcGAgYCAwOhjwQKFOAWBgYGCQMEBAXgAwYDCgoFAAkLCwkKCAsKMAMDCgZAECAQCggICAoKAAoIDgoMBAoMABMKDA0LCwAKBAoFBgkHDIPAAfMDAg4BAwhAGkoMAgARoAQICCETCqYKIwLBEwsUpAMFrANBggMLERELB8ECBpAGBRIM4hYEBOEWkAsWBQTAFgcKoBcACAcDBwQLCwUB4AYKCwkMCwMEGgqgLgogEEAqCwsEQWAgDwsNCw0AEwsADQ4MDAsFCwUwBgoIDcAB8wMCEIABBAgHCAoNAgB6EwEzCcAOYAwjAuEsDBoWpAMGrAOCAwwTE0wMCEA54RYUDQEUA8QEBADBAAwY4BYgMQHiFggEBwQMDAYz4AbAPA0MQAigLgoOFg3gGGAmBMATEAwOCAwODoADDhANDQAMBQwGBwsJDkOhBfIDAhECBDEjDu0CABUiFJEJDDACAQDyCTIYswAUB9wB4wwUFIoN4CIEQCQGFg5zCyIFcQsNGgWBJQgLBAMGICoECAQNDboGkQcN4AogBKEpECAE'
	$vMemFont &= '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'
	$vMemFont &= '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'
	$vMemFont &= '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'
	$vMemFont &= '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'
	$vMemFont &= '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'
	$vMemFont &= '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'
	$vMemFont &= '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'
	$vMemFont &= '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'
	$vMemFont &= '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'
	$vMemFont &= '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'
	$vMemFont &= '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'
	$vMemFont &= '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'
	$vMemFont &= 'aW1lIABqb2IgYW5kIFhldmVwE8UWLEERYQpugBRtEBV0LCBlLm6xCbAD8gljoARpbuGwCXJ1bm6xBcUGogQYY3JlQARQAW5ldwNTB2AiZiB5b3UgAHdvdWxkIGxpfmtiBJULexAvJLUgmidoQHR0cDovL38Cb+ZtqAEbIACpYGCAnRIAUQFhYQB5cABMcAByATAAYgBpAGUALlEQAVQAaLAAc5AAZsAAbwBuAHSQAPUAYnIwAmUAdzID0wJSUXAAYQBkkABhkAJ0VVAAY/ADZRIBdHAAeLXyA2YQBGzQADMFcnAArmTQANECcQFzkgRJsAYF0QEgwLsgAHUAcKswAjEFZbIHdjIIadIEencSAC6QA7kL1QrRBGO1sABtUgVEUgFxBGmSAK2xBGdSA5EFZnAGbBAA65EQkQtjMAFwkgEVDd8GW98G0wYvMAO7Bi6QEHR1kAFskghBkg7xDbkMbauyBxMEbXAFcrAAaTAEAmzyE1m3AHkAcABlACAAAGYAbwB1AG4AIGQAcgB5AHhhAGp0ACh3AgguACwBnG8FAHRlAHxtAGkAYxUAVGMARG0ADiAAVFQAaAAmcwSObgR2YVUCInUAcmQCnmUADiBFAE5uAAoyADAAAjRVAHpFABloABNvAE9lVQI7cgJfUgANZwA9bFUAO3IADWEAg0wCC2HEAGIAIWUAOgBHFT2xARsxADkCARUjVgLNrnOABYFZgUkugkowiE87l06BRyCMSJMKiwYgAF5GhJGBjoOagQ1sgg10dYANIIABZoAAgU6Bn27tgBJxgAOD03KAA4XYhSJ1gVFyguBngASDB4ERZ2+CWYEjgQ2BFHOCx4HlcqOC0oE0IAB2wiFpQh+vQUTFIcURwwZlwnpNQCtaa0JxZ0whwzJtQkBm0UJubAAtwAZpwARBEVpqwApiQjvBmSDABHa7wibBC2TCEUGJQ2MsRorrQQtDpG3EqHRCB0E2xU2/wx3HT0GmwQlBEMNNckIO70FSwy1NNkclY0JYQyLDCq1BUHfKOsFBSUJOecIkq0G7wQFsQhBsQA5rSCP/zVzZg0diR99DwMULSSFD4NdDJsGKwed0QAppwAzBB4poQAN0QB46AC9AAC/lE7MGeYAAAAOBAAAAMP97ABQjAQ4AAQACAQEAAAwA+Aj/AAAIAAj//QAJBAAJoAAKAAr//BAACwALoAAMAAwBoAANAA3/+wAOFAAOoAAPogAQAA9A//oAEQAQoAASBAARoAATABL/+UWgDROgABUAFKAAFkAAFf/4ABeiABgEABagABkAF//3EAAaABigABsAGQGgABwAGv/2AB0UABugAB6iAB8AHBT/9YAnHaAAIQAeEaAAIgAfoAAjACBA//QAJAAhoAAlAaIAJgAi//MAJ0QAI6AAKAAkoAApAAAl//IAKgAmEaAAKwAnoAAsACiM//HAXqEALgApoACgLwAq//CAiSugAAgxACygADIALf8g7wAzAC6gADQAAi+gADUAMP/uAIg2ADGgADcAMqAAKjigAO2AlzOgADoAAjSgADsANf/sAIg8ADagAD0AN6AAgD4AOP/rAD+iAIhAADmgAEEAOqAAAEIAO//qAEMAIjygAEQAPaAARQCoPv/pAE0/oABHogCgSABA/+iAWEGgAAhKAEKgAEsAQ/+K54BTRKAATQBFoACCTqAA5gBPAEagAAhQAEegAFEASf9G5cCcoQBTAEqgAFQAAEv/5ABVAEwRoABWAE2gAFcATkD/4wBYAE+gAFkBogBaAFD/4gBbRABRoABcAFKgAF0AAFP/4QBeAFRRoABfAFWgAGCgAOBFgFJWoABiAFegAGMEAFigAGQAWf/fRUBOWqAAZgBboABnMABc/96AVKEAaQCCXaAAagBe/91AbiJfoABsAGCgAG0A6GH/3MBaYqAAgI6gAKBwAGP/28CoZaAAqHIAZqAAc6AA2sBaYmegAHUAaKAAgG//itmAXWqgAHgAa6AAgHkAbP/Y'
	$vMemFont &= 'AHqiAAh7AG2gAHwAbv8g1wB9AG+gAH4AAnCgAH8Acf/WAIiAAHKgAIEAc6AAAoKiAIMAdP/VAIiEAHWgAIUAdqAAAIYAd//UAIcAonigAIgAeaAAiaAAINMAigB6oACLAAJ7oACMAHz/0gCIjQB9oACOAH6gAICPAH//0QCQogAIkQCAoACSAIL/oNAAkwCDoACUogAAlQCE/88AlgAihaAAlwCGoACYAICH/84AmQCIoAAImgCJoACbAIr/iM0AnKIAnQCLoAAAngCM/8wAnwAijVAAoACOUAChAICP/8sAogCQUAAio1IApACRUAClAICS/8oApgCTUAAIpwCUUACoAJX/oMkAqQCWUACqUgAAqwCX/8gArAAimFAArQCZUACuAICa/8cArwCbUAAIsACcUACxAJ3/IMYAsgCeUACzAAKfUAC0AKD/xQAitVIAtgChUAC3AICi/8QAuACjUAAIuQCkUAC6AKX/IMMAuwCmUAC8AAqnUAC9UADCAL4AIqhQAL8AqVAAwACAqv/BAMEAq1AAiMIArFAAwwCtUACCxFAAwADFAK5QABjGAK9QALAI/78AiMgAsVAAyQCyUACAygCz/74Ay1IACMwAtFAAzQC1/yC9AM4AtlAAzwACt1AA0AC4/7wAiNEAuVAA0gC6UAAA0wC7/7sA1AAivFAA1QC9UADWACC+/7oA11IA2AACv1AA2QDA/7kAiNoAwVAA2wDCUAAA3ADD/7gA3QAKxFAA3lIA3wDF/yC3AOAAxlAA4QAix1AA4gDIUADjAIDJ/7YA5ADKUAAC5VIA5gDL/7UAiOcAzFAA6ADNUAAA6QDO/7QA6gAiz1AA6wDQUADsACDR/7MA7VIA7gAC0lAA7wDT/7IAiPAA1FAA8QDVUAAA8gDW/7EA8wAi11AA9ADYUAD1AIDZ/7AA9gDaUAAo9wDbUAD4UACvAIj5ANxQAPoA3VAAAPsA3v+uAPwAIt9QAP0A4FAA/gAg4f+tAP9RAA=='
	$vMemFont = _WinAPI_Base64Decode($vMemFont)
	Local $tSource = DllStructCreate('byte[' & BinaryLen($vMemFont) & ']')
	DllStructSetData($tSource, 1, $vMemFont)
	Local $tDecompress
	_WinAPI_LZNTDecompress($tSource, $tDecompress, 31304)
	$tSource = 0
	Local $bString = Binary(DllStructGetData($tDecompress, 1))
	If $bSaveBinary Then
		Local $hFile = FileOpen($sSavePath & "\ETHNOCEN.TTF", 18)
		FileWrite($hFile, $bString)
		FileClose($hFile)
	EndIf
	Return $bString
EndFunc   ;==>_MemFont

Func _WinAPI_Base64Decode($sB64String)
	Local $aCrypt = DllCall("Crypt32.dll", "bool", "CryptStringToBinaryA", "str", $sB64String, "dword", 0, "dword", 1, "ptr", 0, "dword*", 0, "ptr", 0, "ptr", 0)
	If @error Or Not $aCrypt[0] Then Return SetError(1, 0, "")
	Local $tBuffer = DllStructCreate("byte[" & $aCrypt[5] & "]")
	$aCrypt = DllCall("Crypt32.dll", "bool", "CryptStringToBinaryA", "str", $sB64String, "dword", 0, "dword", 1, "struct*", $tBuffer, "dword*", $aCrypt[5], "ptr", 0, "ptr", 0)
	If @error Or Not $aCrypt[0] Then Return SetError(2, 0, "")
	Return DllStructGetData($tBuffer, 1)
EndFunc   ;==>_WinAPI_Base64Decode

Func _WinAPI_LZNTDecompress(ByRef $tInput, ByRef $tOutput, $iBufferSize)
	$tOutput = DllStructCreate("byte[" & $iBufferSize & "]")
	If @error Then Return SetError(1, 0, 0)
	Local $aRet = DllCall("ntdll.dll", "uint", "RtlDecompressBuffer", "ushort", 0x0002, "struct*", $tOutput, "ulong", $iBufferSize, "struct*", $tInput, "ulong", DllStructGetSize($tInput), "ulong*", 0)
	If @error Then Return SetError(2, 0, 0)
	If $aRet[0] Then Return SetError(3, $aRet[0], 0)
	Return $aRet[6]
EndFunc   ;==>_WinAPI_LZNTDecompress
