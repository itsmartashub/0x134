package app.revanced.patches.youtube.layout.pivotbar.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import app.revanced.patches.youtube.layout.pivotbar.resource.patch.ResolvePivotBarFingerprintsPatch
import org.jf.dexlib2.Opcode
import org.jf.dexlib2.iface.instruction.WideLiteralInstruction

object InitializeButtonsFingerprint : MethodFingerprint(
    customFingerprint = { methodDef ->
        methodDef.implementation?.instructions?.any {
            it.opcode == Opcode.CONST && (it as WideLiteralInstruction).wideLiteral ==
                    ResolvePivotBarFingerprintsPatch.imageOnlyTabResourceId
        } == true
    }
)